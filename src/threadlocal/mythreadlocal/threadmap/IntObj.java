package threadlocal.mythreadlocal.threadmap;

class IntObj implements Cloneable{
    private int value = 0;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
