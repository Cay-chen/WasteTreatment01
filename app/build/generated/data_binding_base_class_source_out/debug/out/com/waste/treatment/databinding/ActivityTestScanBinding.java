// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTestScanBinding extends ViewDataBinding {
  @NonNull
  public final Button btnClose;

  @NonNull
  public final Button btnOpen;

  @NonNull
  public final Button btnScan;

  @NonNull
  public final EditText edtText;

  protected ActivityTestScanBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnClose, Button btnOpen, Button btnScan, EditText edtText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnClose = btnClose;
    this.btnOpen = btnOpen;
    this.btnScan = btnScan;
    this.edtText = edtText;
  }

  @NonNull
  public static ActivityTestScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_test_scan, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTestScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTestScanBinding>inflateInternal(inflater, R.layout.activity_test_scan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTestScanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_test_scan, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTestScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTestScanBinding>inflateInternal(inflater, R.layout.activity_test_scan, null, false, component);
  }

  public static ActivityTestScanBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityTestScanBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityTestScanBinding)bind(component, view, R.layout.activity_test_scan);
  }
}
