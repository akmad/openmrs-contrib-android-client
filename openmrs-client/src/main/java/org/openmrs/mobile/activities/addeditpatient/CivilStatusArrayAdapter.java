/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.mobile.activities.addeditpatient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.openmrs.mobile.R;
import org.openmrs.mobile.models.ConceptAnswer;

import java.util.List;

public class CivilStatusArrayAdapter extends ArrayAdapter<ConceptAnswer> {

	public CivilStatusArrayAdapter(@NonNull Context context, List<ConceptAnswer> conceptAnswers) {
		super(context, android.R.layout.simple_spinner_item, conceptAnswers);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		ConceptAnswer conceptAnswer = getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.list_item_concept_name, parent, false);
		}

		TextView conceptAnswerText = (TextView)convertView.findViewById(R.id.conceptName);
		assert conceptAnswer != null;
		conceptAnswerText.setText(conceptAnswer.getConcept().getDisplay());

		return convertView;
	}
}
