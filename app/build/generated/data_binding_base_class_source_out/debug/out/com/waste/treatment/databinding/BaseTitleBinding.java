// Generated by data binding compiler. Do not edit!
package com.waste.treatment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BaseTitleBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final FrameLayout layoutContainer;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvLeftText;

  @NonNull
  public final TextView tvRightText;

  @NonNull
  public final TextView tvTitle;

  protected BaseTitleBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivBack, FrameLayout layoutContainer, LinearLayout llTitle, TextView tvLeftText,
      TextView tvRightText, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivBack = ivBack;
    this.layoutContainer = layoutContainer;
    this.llTitle = llTitle;
    this.tvLeftText = tvLeftText;
    this.tvRightText = tvRightText;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static BaseTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.base_title, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BaseTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BaseTitleBinding>inflateInternal(inflater, R.layout.base_title, root, attachToRoot, component);
  }

  @NonNull
  public static BaseTitleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.base_title, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BaseTitleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BaseTitleBinding>inflateInternal(inflater, R.layout.base_title, null, false, component);
  }

  public static BaseTitleBinding bind(@NonNull View view) {
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
  public static BaseTitleBinding bind(@NonNull View view, @Nullable Object component) {
    return (BaseTitleBinding)bind(component, view, R.layout.base_title);
  }
}
