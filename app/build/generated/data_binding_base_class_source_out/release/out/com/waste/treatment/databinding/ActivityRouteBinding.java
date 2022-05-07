// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityRouteBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSc;

  @NonNull
  public final Button endRoute;

  @NonNull
  public final LinearLayout llBangding;

  @NonNull
  public final LinearLayout llWc;

  @NonNull
  public final Spinner spChepai;

  @NonNull
  public final Spinner spSj;

  protected ActivityRouteBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnSc, Button endRoute, LinearLayout llBangding, LinearLayout llWc, Spinner spChepai,
      Spinner spSj) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSc = btnSc;
    this.endRoute = endRoute;
    this.llBangding = llBangding;
    this.llWc = llWc;
    this.spChepai = spChepai;
    this.spSj = spSj;
  }

  @NonNull
  public static ActivityRouteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_route, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRouteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRouteBinding>inflateInternal(inflater, R.layout.activity_route, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRouteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_route, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRouteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRouteBinding>inflateInternal(inflater, R.layout.activity_route, null, false, component);
  }

  public static ActivityRouteBinding bind(@NonNull View view) {
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
  public static ActivityRouteBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityRouteBinding)bind(component, view, R.layout.activity_route);
  }
}
