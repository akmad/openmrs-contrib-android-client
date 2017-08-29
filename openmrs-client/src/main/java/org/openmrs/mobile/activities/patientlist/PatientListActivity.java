/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and
 * limitations under the License.
 *
 * Copyright (C) OpenHMIS.  All Rights Reserved.
 */
package org.openmrs.mobile.activities.patientlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;

import android.view.Menu;
import android.view.MenuItem;
import org.openmrs.mobile.R;
import org.openmrs.mobile.activities.ACBaseActivity;
import org.openmrs.mobile.activities.dialog.SyncSelectionDialogFragment;
import org.openmrs.mobile.activities.dialog.SyncSelectionDialogPresenter;
import org.openmrs.mobile.dagger.DaggerDataAccessComponent;
import org.openmrs.mobile.dagger.DaggerSyncComponent;

/**
 * Patient List activity
 */
public class PatientListActivity extends ACBaseActivity {

	private PatientListContract.Presenter patientListPresenter;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getLayoutInflater().inflate(R.layout.activity_patient_list, frameLayout);

		// create fragment
		PatientListFragment patientListFragment =
				(PatientListFragment)getSupportFragmentManager().findFragmentById(R.id.patientListContentFrame);
		if (patientListFragment == null) {
			patientListFragment = PatientListFragment.newInstance();
		}

		if (!patientListFragment.isActive()) {
			addFragmentToActivity(getSupportFragmentManager(),
					patientListFragment, R.id.patientListContentFrame);
		}

		if (authorizationManager.isUserLoggedIn()) {
			patientListPresenter = new PatientListPresenter(patientListFragment);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu_sync_patient_lists, menu);

		setTitle(R.string.nav_patient_list);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.action_sync) {
			SyncSelectionDialogFragment instance = SyncSelectionDialogFragment.newInstance();
			instance.setRightButtonOnClickListener(v -> patientListPresenter.syncSelectionsSaved());
			SyncSelectionDialogPresenter syncSelectionDialogPresenter = new SyncSelectionDialogPresenter(instance,
					DaggerDataAccessComponent.create().patientList(),
					DaggerSyncComponent.create().pullSubscriptionDbService());
			instance.show(fragmentManager);
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		}
	}
}
