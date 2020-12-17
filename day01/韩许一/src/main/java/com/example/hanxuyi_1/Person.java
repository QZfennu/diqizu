package com.example.hanxuyi_1;

public class Person {
    private Iview iview;
    private Moudel moudel;

    public Person(Iview iview) {
        this.iview = iview;
        this.moudel = new Moudel();
    }
    public void  getlist(){
        moudel.getlist(new CallBACK() {
            @Override
            public void getObjece(Object o) {
                iview.getObjece(o);
            }

            @Override
            public void getExction(String exction) {
                iview.getExction(exction);
            }
        });
    }
}
