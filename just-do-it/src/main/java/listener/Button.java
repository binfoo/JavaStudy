package listener;

public class Button {
    private ButtonClickListener listener;
    public void setClickListener(ButtonClickListener listener){
        this.listener = listener;
    }
    public void click() {
        if (listener!=null){
            listener.onClick();
        }
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.setClickListener(()->System.out.println("Button clicked!"));
        button.click();
    }
}
