// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.baidu.mapapi.map.MapView;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMapBinding extends ViewDataBinding {
  @NonNull
  public final MapView baiduMap;

  protected ActivityMapBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MapView baiduMap) {
    super(_bindingComponent, _root, _localFieldCount);
    this.baiduMap = baiduMap;
  }

  @NonNull
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_map, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMapBinding>inflateInternal(inflater, R.layout.activity_map, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_map, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMapBinding>inflateInternal(inflater, R.layout.activity_map, null, false, component);
  }

  public static ActivityMapBinding bind(@NonNull View view) {
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
  public static ActivityMapBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMapBinding)bind(component, view, R.layout.activity_map);
  }
}
