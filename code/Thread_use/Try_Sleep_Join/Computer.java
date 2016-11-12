package Thread_use.Try_Sleep_Join;

public class Computer{
	private int price;
	private String name;

	public Computer() {
	}

	public Computer(int price, String name){
		this.price=price;
		this.name=name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Computer{" +
				"price=" + price +
				", name='" + name + '\'' +
				'}';
	}
}
