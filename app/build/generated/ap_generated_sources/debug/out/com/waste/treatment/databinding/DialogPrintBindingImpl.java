package com.waste.treatment.databinding;
import com.waste.treatment.R;
import com.waste.treatment.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogPrintBindingImpl extends DialogPrintBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_print, 1);
        sViewsWithIds.put(R.id.edt_lx, 2);
        sViewsWithIds.put(R.id.edt_name, 3);
        sViewsWithIds.put(R.id.edt_id, 4);
        sViewsWithIds.put(R.id.edt_cll, 5);
        sViewsWithIds.put(R.id.edt_time, 6);
        sViewsWithIds.put(R.id.qr_code_img, 7);
        sViewsWithIds.put(R.id.btn_scqr, 8);
        sViewsWithIds.put(R.id.btn_print, 9);
        sViewsWithIds.put(R.id.btn_step, 10);
        sViewsWithIds.put(R.id.edt_w, 11);
        sViewsWithIds.put(R.id.edt_h, 12);
        sViewsWithIds.put(R.id.img111, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogPrintBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private DialogPrintBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[10]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[11]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.RelativeLayout) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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