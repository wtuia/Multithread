package wait_notify;

public class ObjectNum {



    private int num = 10;
    public int count = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.setCount();
        this.num = num;
    }

    private void setCount(){
        count++;
    }
}

