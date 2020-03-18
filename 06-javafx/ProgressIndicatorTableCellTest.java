/*
 * Portions of this code (ProgressIndicatorTableCell) are base upon Oracle
 * JavaFX code (ProgressBarTableCell), which is subject to the following license term.
 * 
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

//package test;

import java.util.Random;
import java.util.concurrent.*;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ProgressIndicatorTableCellTest extends Application {
  public void start(Stage primaryStage) {
    TableView<TestTask> table = new TableView<>();
    Random rng = new Random();
    for (int i = 0; i < 20; i++) {
      table.getItems().add(
              new TestTask(rng.nextInt(3000) + 2000, rng.nextInt(30) + 20));
    }

    TableColumn<TestTask, String> statusCol = new TableColumn("Status");
    statusCol.setCellValueFactory(new PropertyValueFactory<TestTask, String>(
            "message"));
    statusCol.setPrefWidth(75);

    TableColumn<TestTask, Double> progressCol = new TableColumn("Progress");
    progressCol.setCellValueFactory(new PropertyValueFactory<TestTask, Double>(
            "progress"));
    progressCol
            .setCellFactory(ProgressIndicatorTableCell.<TestTask>forTableColumn());

    table.getColumns().addAll(statusCol, progressCol);

    BorderPane root = new BorderPane();
    root.setCenter(table);
    primaryStage.setScene(new Scene(root));
    primaryStage.show();

    ExecutorService executor = Executors.newFixedThreadPool(table.getItems().size(), new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
      }
    });


    for (TestTask task : table.getItems()) {
      executor.execute(task);
    }
  }

  public static void main(String[] args) { launch(args); }

  static class TestTask extends Task<Void> {
    private final int waitTime; // milliseconds
    private final int pauseTime; // milliseconds
    public static final int NUM_ITERATIONS = 100;

    TestTask(int waitTime, int pauseTime) {
      this.waitTime = waitTime;
      this.pauseTime = pauseTime;
    }

    @Override
    protected Void call() throws Exception {
      this.updateProgress(ProgressIndicator.INDETERMINATE_PROGRESS, 1);
      this.updateMessage("Waiting...");
      Thread.sleep(waitTime);
      this.updateMessage("Running...");
      for (int i = 0; i < NUM_ITERATIONS; i++) {
        updateProgress((1.0 * i) / NUM_ITERATIONS, 1);
        Thread.sleep(pauseTime);
      }
      this.updateMessage("Done");
      this.updateProgress(1, 1);
      return null;
    }
  }
}

class ProgressIndicatorTableCell<S> extends TableCell<S, Double> {
  public static <S> Callback<TableColumn<S, Double>, TableCell<S, Double>> forTableColumn() {
    return new Callback<TableColumn<S, Double>, TableCell<S, Double>>() {
      @Override
      public TableCell<S, Double> call(TableColumn<S, Double> param) {
        return new ProgressIndicatorTableCell<>();
      }
    };
  }

  private final ProgressIndicator progressIndicator;
  private ObservableValue observable;

  public ProgressIndicatorTableCell() {
    this.getStyleClass().add("progress-indicator-table-cell");

    this.progressIndicator = new ProgressIndicator();
    setGraphic(progressIndicator);
  }

  @Override public void updateItem(Double item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setGraphic(null);
    } else {
      progressIndicator.progressProperty().unbind();

      observable = getTableColumn().getCellObservableValue(getIndex());
      if (observable != null) {
        progressIndicator.progressProperty().bind(observable);
      } else {
        progressIndicator.setProgress(item);
      }

      setGraphic(progressIndicator);
    }
  }
}