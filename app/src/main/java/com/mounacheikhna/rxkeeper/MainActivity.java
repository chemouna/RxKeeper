package com.mounacheikhna.rxkeeper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements Observer<String> {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act);
    ((TextView)findViewById(R.id.main)).setText("Activity 1");
    ObservableFragmentWrapper.register(this, new FunctionDumb());

  }

  @Override
  public void onCompleted() {
    ((TextView)findViewById(R.id.main)).setText("Finished");
  }

  @Override
  public void onError(Throwable throwable) {
    ((TextView)findViewById(R.id.main)).setText(throwable.getLocalizedMessage());
  }

  @Override
  public void onNext(String s) {
    ((TextView)findViewById(R.id.main)).setText(s);
  }
}