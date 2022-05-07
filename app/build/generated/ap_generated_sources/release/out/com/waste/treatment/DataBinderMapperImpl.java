package com.waste.treatment;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.waste.treatment.databinding.ActivityBaseBindingImpl;
import com.waste.treatment.databinding.ActivityChangePasswordBindingImpl;
import com.waste.treatment.databinding.ActivityCollectBindingImpl;
import com.waste.treatment.databinding.ActivityDaiBindingImpl;
import com.waste.treatment.databinding.ActivityGpsBindingImpl;
import com.waste.treatment.databinding.ActivityImgBindingImpl;
import com.waste.treatment.databinding.ActivityInvalidRecyleBindingImpl;
import com.waste.treatment.databinding.ActivityListViewBindingImpl;
import com.waste.treatment.databinding.ActivityLoginBindingImpl;
import com.waste.treatment.databinding.ActivityMainBindingImpl;
import com.waste.treatment.databinding.ActivityMapBindingImpl;
import com.waste.treatment.databinding.ActivityMapTestBindingImpl;
import com.waste.treatment.databinding.ActivityPrintBindingImpl;
import com.waste.treatment.databinding.ActivityPrintSetBindingImpl;
import com.waste.treatment.databinding.ActivityPrintTestBindingImpl;
import com.waste.treatment.databinding.ActivityQueryBindingImpl;
import com.waste.treatment.databinding.ActivityRouteBindingImpl;
import com.waste.treatment.databinding.ActivityRuiKu1BindingImpl;
import com.waste.treatment.databinding.ActivityTestFramgeBindingImpl;
import com.waste.treatment.databinding.ActivityTestScanBindingImpl;
import com.waste.treatment.databinding.ActivityTraceBindingImpl;
import com.waste.treatment.databinding.ActivityUploadImageBindingImpl;
import com.waste.treatment.databinding.AlBaseTitleBindingImpl;
import com.waste.treatment.databinding.BaseTitleBindingImpl;
import com.waste.treatment.databinding.DialogPrintBindingImpl;
import com.waste.treatment.databinding.FragmentBaseBindingImpl;
import com.waste.treatment.databinding.FragmentHomeBindingImpl;
import com.waste.treatment.databinding.FragmentSetBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBASE = 1;

  private static final int LAYOUT_ACTIVITYCHANGEPASSWORD = 2;

  private static final int LAYOUT_ACTIVITYCOLLECT = 3;

  private static final int LAYOUT_ACTIVITYDAI = 4;

  private static final int LAYOUT_ACTIVITYGPS = 5;

  private static final int LAYOUT_ACTIVITYIMG = 6;

  private static final int LAYOUT_ACTIVITYINVALIDRECYLE = 7;

  private static final int LAYOUT_ACTIVITYLISTVIEW = 8;

  private static final int LAYOUT_ACTIVITYLOGIN = 9;

  private static final int LAYOUT_ACTIVITYMAIN = 10;

  private static final int LAYOUT_ACTIVITYMAP = 11;

  private static final int LAYOUT_ACTIVITYMAPTEST = 12;

  private static final int LAYOUT_ACTIVITYPRINT = 13;

  private static final int LAYOUT_ACTIVITYPRINTSET = 14;

  private static final int LAYOUT_ACTIVITYPRINTTEST = 15;

  private static final int LAYOUT_ACTIVITYQUERY = 16;

  private static final int LAYOUT_ACTIVITYROUTE = 17;

  private static final int LAYOUT_ACTIVITYRUIKU1 = 18;

  private static final int LAYOUT_ACTIVITYTESTFRAMGE = 19;

  private static final int LAYOUT_ACTIVITYTESTSCAN = 20;

  private static final int LAYOUT_ACTIVITYTRACE = 21;

  private static final int LAYOUT_ACTIVITYUPLOADIMAGE = 22;

  private static final int LAYOUT_ALBASETITLE = 23;

  private static final int LAYOUT_BASETITLE = 24;

  private static final int LAYOUT_DIALOGPRINT = 25;

  private static final int LAYOUT_FRAGMENTBASE = 26;

  private static final int LAYOUT_FRAGMENTHOME = 27;

  private static final int LAYOUT_FRAGMENTSET = 28;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(28);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_base, LAYOUT_ACTIVITYBASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_change_password, LAYOUT_ACTIVITYCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_collect, LAYOUT_ACTIVITYCOLLECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_dai, LAYOUT_ACTIVITYDAI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_gps, LAYOUT_ACTIVITYGPS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_img, LAYOUT_ACTIVITYIMG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_invalid_recyle, LAYOUT_ACTIVITYINVALIDRECYLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_list_view, LAYOUT_ACTIVITYLISTVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_map, LAYOUT_ACTIVITYMAP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_map_test, LAYOUT_ACTIVITYMAPTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_print, LAYOUT_ACTIVITYPRINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_print_set, LAYOUT_ACTIVITYPRINTSET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_print_test, LAYOUT_ACTIVITYPRINTTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_query, LAYOUT_ACTIVITYQUERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_route, LAYOUT_ACTIVITYROUTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_rui_ku1, LAYOUT_ACTIVITYRUIKU1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_test_framge, LAYOUT_ACTIVITYTESTFRAMGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_test_scan, LAYOUT_ACTIVITYTESTSCAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_trace, LAYOUT_ACTIVITYTRACE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.activity_upload_image, LAYOUT_ACTIVITYUPLOADIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.al_base_title, LAYOUT_ALBASETITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.base_title, LAYOUT_BASETITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.dialog_print, LAYOUT_DIALOGPRINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.fragment_base, LAYOUT_FRAGMENTBASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.waste.treatment.R.layout.fragment_set, LAYOUT_FRAGMENTSET);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBASE: {
          if ("layout/activity_base_0".equals(tag)) {
            return new ActivityBaseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_base is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCHANGEPASSWORD: {
          if ("layout/activity_change_password_0".equals(tag)) {
            return new ActivityChangePasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_change_password is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCOLLECT: {
          if ("layout/activity_collect_0".equals(tag)) {
            return new ActivityCollectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_collect is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDAI: {
          if ("layout/activity_dai_0".equals(tag)) {
            return new ActivityDaiBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_dai is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYGPS: {
          if ("layout/activity_gps_0".equals(tag)) {
            return new ActivityGpsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_gps is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYIMG: {
          if ("layout/activity_img_0".equals(tag)) {
            return new ActivityImgBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_img is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINVALIDRECYLE: {
          if ("layout/activity_invalid_recyle_0".equals(tag)) {
            return new ActivityInvalidRecyleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_invalid_recyle is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLISTVIEW: {
          if ("layout/activity_list_view_0".equals(tag)) {
            return new ActivityListViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_list_view is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAP: {
          if ("layout/activity_map_0".equals(tag)) {
            return new ActivityMapBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_map is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAPTEST: {
          if ("layout/activity_map_test_0".equals(tag)) {
            return new ActivityMapTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_map_test is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRINT: {
          if ("layout/activity_print_0".equals(tag)) {
            return new ActivityPrintBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_print is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRINTSET: {
          if ("layout/activity_print_set_0".equals(tag)) {
            return new ActivityPrintSetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_print_set is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRINTTEST: {
          if ("layout/activity_print_test_0".equals(tag)) {
            return new ActivityPrintTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_print_test is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYQUERY: {
          if ("layout/activity_query_0".equals(tag)) {
            return new ActivityQueryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_query is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYROUTE: {
          if ("layout/activity_route_0".equals(tag)) {
            return new ActivityRouteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_route is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRUIKU1: {
          if ("layout/activity_rui_ku1_0".equals(tag)) {
            return new ActivityRuiKu1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_rui_ku1 is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTESTFRAMGE: {
          if ("layout/activity_test_framge_0".equals(tag)) {
            return new ActivityTestFramgeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_test_framge is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTESTSCAN: {
          if ("layout/activity_test_scan_0".equals(tag)) {
            return new ActivityTestScanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_test_scan is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTRACE: {
          if ("layout/activity_trace_0".equals(tag)) {
            return new ActivityTraceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_trace is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUPLOADIMAGE: {
          if ("layout/activity_upload_image_0".equals(tag)) {
            return new ActivityUploadImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_upload_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ALBASETITLE: {
          if ("layout/al_base_title_0".equals(tag)) {
            return new AlBaseTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for al_base_title is invalid. Received: " + tag);
        }
        case  LAYOUT_BASETITLE: {
          if ("layout/base_title_0".equals(tag)) {
            return new BaseTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for base_title is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGPRINT: {
          if ("layout/dialog_print_0".equals(tag)) {
            return new DialogPrintBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_print is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBASE: {
          if ("layout/fragment_base_0".equals(tag)) {
            return new FragmentBaseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_base is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSET: {
          if ("layout/fragment_set_0".equals(tag)) {
            return new FragmentSetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_set is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.chad.library.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(28);

    static {
      sKeys.put("layout/activity_base_0", com.waste.treatment.R.layout.activity_base);
      sKeys.put("layout/activity_change_password_0", com.waste.treatment.R.layout.activity_change_password);
      sKeys.put("layout/activity_collect_0", com.waste.treatment.R.layout.activity_collect);
      sKeys.put("layout/activity_dai_0", com.waste.treatment.R.layout.activity_dai);
      sKeys.put("layout/activity_gps_0", com.waste.treatment.R.layout.activity_gps);
      sKeys.put("layout/activity_img_0", com.waste.treatment.R.layout.activity_img);
      sKeys.put("layout/activity_invalid_recyle_0", com.waste.treatment.R.layout.activity_invalid_recyle);
      sKeys.put("layout/activity_list_view_0", com.waste.treatment.R.layout.activity_list_view);
      sKeys.put("layout/activity_login_0", com.waste.treatment.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.waste.treatment.R.layout.activity_main);
      sKeys.put("layout/activity_map_0", com.waste.treatment.R.layout.activity_map);
      sKeys.put("layout/activity_map_test_0", com.waste.treatment.R.layout.activity_map_test);
      sKeys.put("layout/activity_print_0", com.waste.treatment.R.layout.activity_print);
      sKeys.put("layout/activity_print_set_0", com.waste.treatment.R.layout.activity_print_set);
      sKeys.put("layout/activity_print_test_0", com.waste.treatment.R.layout.activity_print_test);
      sKeys.put("layout/activity_query_0", com.waste.treatment.R.layout.activity_query);
      sKeys.put("layout/activity_route_0", com.waste.treatment.R.layout.activity_route);
      sKeys.put("layout/activity_rui_ku1_0", com.waste.treatment.R.layout.activity_rui_ku1);
      sKeys.put("layout/activity_test_framge_0", com.waste.treatment.R.layout.activity_test_framge);
      sKeys.put("layout/activity_test_scan_0", com.waste.treatment.R.layout.activity_test_scan);
      sKeys.put("layout/activity_trace_0", com.waste.treatment.R.layout.activity_trace);
      sKeys.put("layout/activity_upload_image_0", com.waste.treatment.R.layout.activity_upload_image);
      sKeys.put("layout/al_base_title_0", com.waste.treatment.R.layout.al_base_title);
      sKeys.put("layout/base_title_0", com.waste.treatment.R.layout.base_title);
      sKeys.put("layout/dialog_print_0", com.waste.treatment.R.layout.dialog_print);
      sKeys.put("layout/fragment_base_0", com.waste.treatment.R.layout.fragment_base);
      sKeys.put("layout/fragment_home_0", com.waste.treatment.R.layout.fragment_home);
      sKeys.put("layout/fragment_set_0", com.waste.treatment.R.layout.fragment_set);
    }
  }
}
