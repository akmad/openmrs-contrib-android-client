package org.openmrs.mobile.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import org.openmrs.mobile.models.Visit;

public interface IBaseDiagnosisFragment {

	void setDiagnoses(Visit visit);

	void initializeListeners();

	void initializeViewFields(View v);

	void setSearchDiagnosisView(AutoCompleteTextView view);

	AutoCompleteTextView getSearchDiagnosisView();

	TextInputEditText getClinicalNoteView();
	void setClinicalNoteView(TextInputEditText clinicalNoteView);

	void setNoPrimaryDiagnoses(TextView view);
	TextView getNoPrimaryDiagnoses();

	void setNoSecondaryDiagnoses(TextView view);
	TextView getNoSecondaryDiagnoses();

	void setPrimaryDiagnosesRecycler(RecyclerView view);
	RecyclerView getPrimaryDiagnosesRecycler();

	void setSecondaryDiagnosesRecycler(RecyclerView view);
	RecyclerView getSecondaryDiagnosesRecycler();

	void setEncounterUuid(String encounterUuid);
	String getEncounterUuid();

	void setVisit(Visit visit);
	Visit getVisit();

	IBaseDiagnosisView getBaseDiagnosisView();
}
