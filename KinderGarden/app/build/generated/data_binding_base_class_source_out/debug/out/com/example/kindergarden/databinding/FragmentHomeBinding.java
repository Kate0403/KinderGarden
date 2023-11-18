// Generated by view binder compiler. Do not edit!
package com.example.kindergarden.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kindergarden.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton btnSend;

  @NonNull
  public final EditText messageField;

  @NonNull
  public final TextInputLayout textLayout;

  private FragmentHomeBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton btnSend, @NonNull EditText messageField,
      @NonNull TextInputLayout textLayout) {
    this.rootView = rootView;
    this.btnSend = btnSend;
    this.messageField = messageField;
    this.textLayout = textLayout;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSend;
      FloatingActionButton btnSend = ViewBindings.findChildViewById(rootView, id);
      if (btnSend == null) {
        break missingId;
      }

      id = R.id.messageField;
      EditText messageField = ViewBindings.findChildViewById(rootView, id);
      if (messageField == null) {
        break missingId;
      }

      id = R.id.textLayout;
      TextInputLayout textLayout = ViewBindings.findChildViewById(rootView, id);
      if (textLayout == null) {
        break missingId;
      }

      return new FragmentHomeBinding((RelativeLayout) rootView, btnSend, messageField, textLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}