package com.ljaer.designpatterns.observer.mouseevent;

public class MouseTest {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();
        // 注册行为
        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK, callback);
        mouse.addLisenter(MouseEventType.ON_DOUBLE_CLICK, callback);
        mouse.addLisenter(MouseEventType.ON_UP, callback);
        mouse.addLisenter(MouseEventType.ON_DOWN, callback);
        mouse.addLisenter(MouseEventType.ON_MOVE, callback);
        mouse.addLisenter(MouseEventType.ON_OVER, callback);
        mouse.addLisenter(MouseEventType.ON_WHEEL, callback);
        mouse.addLisenter(MouseEventType.ON_BLUR, callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS, callback);

        // 鼠标事件
        mouse.click();
        mouse.focus();
        mouse.down();
    }
}
