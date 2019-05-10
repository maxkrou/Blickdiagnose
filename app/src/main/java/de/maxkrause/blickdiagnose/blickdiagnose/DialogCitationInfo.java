package de.maxkrause.blickdiagnose.blickdiagnose;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Html;

public class DialogCitationInfo extends AppCompatDialogFragment {

    private String title;
    private String message;

    public void setDialogTexts(String title_, String message_){
        title=title_;
        message=message_;
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage(message)
                //.setMessage(Html.fromHtml("Hellerhoff [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Hufeisenniere_CT_axial.jpg\">via Wikimedia Commons</a>"))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}


