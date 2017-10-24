package com.example.dizzer.vidmetestproject.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dizzer.vidmetestproject.App;
import com.example.dizzer.vidmetestproject.R;
import com.example.dizzer.vidmetestproject.UserVideoActivity;
import com.example.dizzer.vidmetestproject.model.LogInResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dizzer on 10/24/2017.
 */

public class AuthFragment extends Fragment {

    @BindView(R.id.loginTE)
    EditText loginTE;
    @BindView(R.id.passwordTE)
    EditText passwordTE;
    @BindView(R.id.singInBtn)
    Button singInBtn;

    public static final String TOKEN = "token";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    Unbinder unbinder;
    Call<LogInResult> call;

    String loginValue;
    String passwordValue;
    String savedLogin;
    String savedPassword;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.auth_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        SharedPreferences UsernameAndPasswordValues = getActivity().getSharedPreferences("Auth",Context.MODE_PRIVATE);
        savedLogin = UsernameAndPasswordValues.getString(LOGIN,null);
        savedPassword = UsernameAndPasswordValues.getString(PASSWORD,null);

        if(savedLogin!=null & savedPassword!=null){
            Authorize();
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.singInBtn)
    public void Authorize(){
        loginValue = loginTE.getText().toString();
        passwordValue = passwordTE.getText().toString();

        SharedPreferences SavedUsernameAndPasswordValues = getActivity().getSharedPreferences("Auth",Context.MODE_PRIVATE);
        savedLogin = SavedUsernameAndPasswordValues.getString(LOGIN,null);
        savedPassword = SavedUsernameAndPasswordValues.getString(PASSWORD,null);
        if(savedLogin ==null || savedPassword ==null) {
            call = App.getApi().insertUser(loginValue, passwordValue);
        }
        else{
            call = App.getApi().insertUser(savedLogin, savedPassword);
        }
        call.enqueue(new Callback<LogInResult>() {


            @Override
            public void onResponse(Call<LogInResult> call, Response<LogInResult> response) {
                if(response.body()==null){
                    buildDialog(getActivity()).show();
                    SharedPreferences failConnectionValues = getActivity().getSharedPreferences("Auth",Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = failConnectionValues.edit();
                    edit.putString(LOGIN,null);
                    edit.putString(PASSWORD,null);
                    edit.commit();
                }
                else {
                    Boolean i = response.body().getStatus();
                    if (i) {

                        SharedPreferences successfulConnectionValues = getActivity().getSharedPreferences("Auth",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = successfulConnectionValues.edit();
                        editor.putString(TOKEN, response.body().getAuth().getToken());
                        editor.putString(LOGIN, loginValue);
                        editor.putString(PASSWORD, passwordValue);
                        editor.commit();

                        Toast.makeText(getActivity(),"You log in",Toast.LENGTH_LONG).show();
//                        Intent user_activity_intent = new Intent(getActivity(), UserVideoActivity.class);
//                        startActivity(user_activity_intent);

                    }
                }
            }

            @Override
            public void onFailure(Call<LogInResult> call, Throwable t) {

                call.cancel();
                buildDialog(getActivity());
            }
        });
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Invalid password ");
        builder.setMessage("The password you entered was not valid");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        return builder;
    }
}


