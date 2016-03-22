/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.business.database.dao.impl
 *	Class: RuleRepositoryImpl.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */
package org.w00tdevs.project.sonarviewer.database.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.w00tdevs.project.sonarviewer.database.dao.GenericCustomRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;

/**
 * The Class RuleRepositoryImpl.
 */
/**
 * @author Alberto
 *
 */
public class RuleRepositoryImpl implements GenericCustomRepository<Rule> {

	/** The entity manager. */
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.business.database.dao.
	 * GenericCustomRepository#saveIfNotExists(java.util.List)
	 */
	@Override
	public List<Rule> saveIfNotExists(List<Rule> entities) {
		for (Rule rule : entities) {
			Rule savedRule = getByKey(rule.getKey());
			if (savedRule != null) {
				rule = savedRule;
			} else {
				rule = (Rule) sessionFactory.getCurrentSession().save(rule);
			}
		}
		return entities;
	}

	/**
	 * Gets the by key.
	 *
	 * @param key
	 *            the key
	 * @return the by key
	 */
	private Rule getByKey(String key) {
		Rule rule = (Rule) sessionFactory.getCurrentSession().createCriteria(Rule.class)
				.add(Restrictions.eq("key", key)).uniqueResult();
		return rule;

	}

}
