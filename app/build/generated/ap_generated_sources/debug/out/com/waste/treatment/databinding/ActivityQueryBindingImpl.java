package com.waste.treatment.databinding;
import com.waste.treatment.R;
import com.waste.treatment.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityQueryBindingImpl extends ActivityQueryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_back, 1);
        sViewsWithIds.put(R.id.edt_code, 2);
        sViewsWithIds.put(R.id.tv_right_text, 3);
        sViewsWithIds.put(R.id.tv_gsmc, 4);
        sViewsWithIds.put(R.id.tv_fwbm, 5);
        sViewsWithIds.put(R.id.tv_fwlx, 6);
        sViewsWithIds.put(R.id.tv_fwzl, 7);
        sViewsWithIds.put(R.id.tv_sjsj, 8);
        sViewsWithIds.put(R.id.tv_yscp, 9);
        sViewsWithIds.put(R.id.tv_yssj, 10);
        sViewsWithIds.put(R.id.tv_sjr, 11);
        sViewsWithIds.put(R.id.print_btn, 12);
        sViewsWithIds.put(R.id.ll_map, 13);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityQueryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityQueryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.Button) bindings[12]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            );
        this.llTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}