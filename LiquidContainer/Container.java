import java.lang.Math;
public class Container {
	private int container;
	
	public Container() {
		this.container = 0;//upper limit is 100, lower limit is 0
	}
	public int contains() {
		return this.container;
	}
	public void add(int i) {//add liquid to container
		this.container = Math.min(100, this.container + i);
	}
	public void move(Container c, int i) {//pour liquid from one container to another
		c.container = Math.min(100, c.container + (i > this.container? this.container : i));
		// or c.container = Math.min(100, Math.min(c.container + this.container , c.container + i));
		this.container = Math.max(0, this.container - i);
	}
	public void remove(int i) {//remove liquid from container
		this.container = Math.max(0, this.container - i);		
	}
	public String toString() {
		return this.container + "/100";
	}
}
