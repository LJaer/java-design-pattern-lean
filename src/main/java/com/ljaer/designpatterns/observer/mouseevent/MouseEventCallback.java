package com.ljaer.designpatterns.observer.mouseevent;

public class MouseEventCallback {
    public void onClick(Event e){
        System.out.println("======获取鼠标单击事件======"+"\n"+e);
    }

    public void onDoubleClick(Event e){
        System.out.println("======获取鼠标双击事件======"+"\n"+e);
    }

    public void onUp(Event e){
        System.out.println("======获取鼠标弹起事件======"+"\n"+e);
    }

    public void onDown(Event e){
        System.out.println("======获取鼠标按下事件======"+"\n"+e);
    }

    public void onMove(Event e){
        System.out.println("======获取鼠标移动事件======"+"\n"+e);
    }

    public void onWheel(Event e){
        System.out.println("======获取鼠标滚动事件======"+"\n"+e);
    }

    public void onOver(Event e){
        System.out.println("======获取鼠标悬浮事件======"+"\n"+e);
    }

    public void onBlur(Event e){
        System.out.println("======获取鼠标获焦事件======"+"\n"+e);
    }

    public void onFocus(Event e){
        System.out.println("======获取鼠标失焦事件======"+"\n"+e);
    }
}
