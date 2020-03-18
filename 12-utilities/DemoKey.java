/**
  * <p>Класс "Ключ" - простая абстракция ключа</p>
  * пока реализовано 3 метода
  */
class Key
{
	/**
    * Вставка ключа в замок
    */
	void push() {
		System.out.println("push key");
	}
	/**
    * Поворот ключа
    */
	void turn() {
		System.out.println("turn key");
	}
	/**
    * Извлечение ключа из замка
    */
 	void pop() {
		System.out.println("pop key");
	}
    /**
    * Метод открытия двери
    */
    public void open() {
    	push();
    	turn();
    	pop();
    	System.out.println("Open!");

    }
}
/**
  * <p>Демонстрация работы с ключом</p>
  * Ключ используется для открытия двери
  */
public class DemoKey
{
	public static void main(String[] args) {
		Key key=new Key();
		key.open();
	}
}