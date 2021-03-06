// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityListViewBinding extends ViewDataBinding {
  @NonNull
  public final BaseTitleBinding ilTitle;

  @NonNull
  public final RecyclerView rvList;

  protected ActivityListViewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BaseTitleBinding ilTitle, RecyclerView rvList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ilTitle = ilTitle;
    setContainedBinding(this.ilTitle);
    this.rvList = rvList;
  }

  @NonNull
  public static ActivityListViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_list_view, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityListViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityListViewBinding>inflateInternal(inflater, R.layout.activity_list_view, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityListViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_list_view, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityListViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityListViewBinding>inflateInternal(inflater, R.layout.activity_list_view, null, false, component);
  }

  public static ActivityListViewBinding bind(@NonNull View view) {
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
  public static ActivityListViewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityListViewBinding)bind(component, view, R.layout.activity_list_view);
  }
}
