/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.dozer
*	Class: MyCustomFieldMapper.java
*	Author: Alberto
*	Last update: 04-abr-2016
*/
package org.w00tdevs.project.sonarviewer.dozer;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.collection.internal.PersistentSet;

/**
 * The Class MyCustomFieldMapper.
 */
// Solution from here : http://stackoverflow.com/a/5963582
public class MyCustomFieldMapper implements CustomFieldMapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomFieldMapper#mapField(java.lang.Object,
	 * java.lang.Object, java.lang.Object, org.dozer.classmap.ClassMap,
	 * org.dozer.fieldmap.FieldMap)
	 */
	@Override
	public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap,
			FieldMap fieldMapping) {
		// Check if field is a Hibernate PersistentSet
		if (!(sourceFieldValue instanceof PersistentSet) && !(sourceFieldValue instanceof PersistentBag)) {
			// Allow dozer to map as normal
			return false;
		}
		// Check if field is already initialized
		if ((sourceFieldValue instanceof PersistentSet) && ((PersistentSet) sourceFieldValue).wasInitialized()) {
			// Allow dozer to map as normal
			return false;
		}
		// Check if field is already initialized
		if ((sourceFieldValue instanceof PersistentBag) && ((PersistentBag) sourceFieldValue).wasInitialized()) {
			// Allow dozer to map as normal
			return false;
		}

		// Set destination to null, and tell dozer that the field is mapped
		destination = null;
		return true;
	}
}