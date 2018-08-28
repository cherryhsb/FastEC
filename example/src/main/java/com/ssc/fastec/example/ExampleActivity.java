package com.ssc.fastec.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ssc.latte_core.activities.ProxyActivity;
import com.ssc.latte_core.delegate.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelagete();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
}
