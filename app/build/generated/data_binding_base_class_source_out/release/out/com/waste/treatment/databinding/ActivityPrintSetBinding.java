// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPrintSetBinding extends ViewDataBinding {
  @NonNull
  public final BaseTitleBinding ilTitle;

  @NonNull
  public final EditText printHEdt;

  @NonNull
  public final Button printReviseBtn;

  @NonNull
  public final EditText printWEdt;

  @NonNull
  public final Spinner spinnerGray;

  protected ActivityPrintSetBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BaseTitleBinding ilTitle, EditText printHEdt, Button printReviseBtn, EditText printWEdt,
      Spinner spinnerGray) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ilTitle = ilTitle;
    setContainedBinding(this.ilTitle);
    this.printHEdt = printHEdt;
    this.printReviseBtn = printReviseBtn;
    this.printWEdt = printWEdt;
    this.spinnerGray = spinnerGray;
  }

  @NonNull
  public static ActivityPrintSetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_print_set, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPrintSetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPrintSetBinding>inflateInternal(inflater, R.layout.activity_print_set, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPrintSetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_print_set, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPrintSetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPrintSetBinding>inflateInternal(inflater, R.layout.activity_print_set, null, false, component);
  }

  public static ActivityPrintSetBinding bind(@NonNull View view) {
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
  public static ActivityPrintSetBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPrintSetBinding)bind(component, view, R.layout.activity_print_set);
  }
}
