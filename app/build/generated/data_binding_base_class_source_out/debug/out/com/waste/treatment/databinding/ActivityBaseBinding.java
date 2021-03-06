// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityBaseBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout container;

  @NonNull
  public final BaseTitleBinding ilTitle;

  @NonNull
  public final ImageView imgErr;

  @NonNull
  public final ImageView imgProgress;

  @NonNull
  public final LinearLayout llErrorRefresh;

  @NonNull
  public final LinearLayout llProgressBar;

  @NonNull
  public final RelativeLayout rlContentPart;

  protected ActivityBaseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout container, BaseTitleBinding ilTitle, ImageView imgErr, ImageView imgProgress,
      LinearLayout llErrorRefresh, LinearLayout llProgressBar, RelativeLayout rlContentPart) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.ilTitle = ilTitle;
    setContainedBinding(this.ilTitle);
    this.imgErr = imgErr;
    this.imgProgress = imgProgress;
    this.llErrorRefresh = llErrorRefresh;
    this.llProgressBar = llProgressBar;
    this.rlContentPart = rlContentPart;
  }

  @NonNull
  public static ActivityBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_base, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityBaseBinding>inflateInternal(inflater, R.layout.activity_base, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBaseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_base, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityBaseBinding>inflateInternal(inflater, R.layout.activity_base, null, false, component);
  }

  public static ActivityBaseBinding bind(@NonNull View view) {
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
  public static ActivityBaseBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityBaseBinding)bind(component, view, R.layout.activity_base);
  }
}
