// $Id$
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css1;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssIdent;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;

/**
 * @spec http://www.w3.org/TR/2008/REC-CSS1-20080411/#text-align
 */
public class CssTextAlign extends org.w3c.css.properties.css.CssTextAlign {

	private static CssIdent[] allowed_values;

	static {
		String[] _allowed_values = {"left", "right", "center", "justify"};

		allowed_values = new CssIdent[_allowed_values.length];
		int i = 0;
		for (String s : _allowed_values) {
			allowed_values[i++] = CssIdent.getIdent(s);
		}
	}

	public static CssIdent getMatchingIdent(CssIdent ident) {
		for (CssIdent id : allowed_values) {
			if (id.equals(ident)) {
				return id;
			}
		}
		return null;
	}

	/**
	 * Create a new CssTextAlign
	 */
	public CssTextAlign() {
	}

	/**
	 * Creates a new CssTextAlign
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssTextAlign(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		setByUser();
		CssValue val = expression.getValue();

		if (check && expression.getCount() > 1) {
			throw new InvalidParamException("unrecognize", ac);
		}

		if (val.getType() != CssTypes.CSS_IDENT) {
			throw new InvalidParamException("value",
					expression.getValue(),
					getPropertyName(), ac);
		}
		// ident, so inherit, or allowed value
		val = getMatchingIdent((CssIdent) val);
		if (val == null) {
			throw new InvalidParamException("value",
					expression.getValue(),
					getPropertyName(), ac);
		}
		value = val;
		expression.next();
	}

	public CssTextAlign(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}
}

