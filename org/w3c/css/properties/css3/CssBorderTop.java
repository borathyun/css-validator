// $Id$
// From Philippe Le Hegaret (Philippe.Le_Hegaret@sophia.inria.fr)
// Rewritten 2010 Yves Lafon <ylafon@w3.org>

// (c) COPYRIGHT MIT, ERCIM and Keio, 1997-2010.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @since CSS1
 */
public class CssBorderTop extends org.w3c.css.properties.css.CssBorderTop {

    /**
     * Create a new CssBorderTop
     */
    public CssBorderTop() {
        value = initial;
        _width = new CssBorderTopWidth();
        _style = new CssBorderTopStyle();
        _color = new CssBorderTopColor();
    }

    /**
     * Set the value of the property<br/>
     * Does not check the number of values
     *
     * @param expression The expression for this property
     * @throws org.w3c.css.util.InvalidParamException
     *          The expression is incorrect
     */
    public CssBorderTop(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }

    /**
     * Set the value of the property
     *
     * @param expression The expression for this property
     * @param check      set it to true to check the number of values
     * @throws org.w3c.css.util.InvalidParamException
     *          The expression is incorrect
     */
    public CssBorderTop(ApplContext ac, CssExpression expression,
                        boolean check) throws InvalidParamException {
        CssBorder.SideValues values = CssBorder.checkBorderSide(ac, this, expression, check);
        if (values.width != null) {
            _width = new CssBorderTopWidth();
            _width.setByUser();
            _width.value = values.width;
        }
        if (values.style != null) {
            _style = new CssBorderTopStyle();
            _style.setByUser();
            _style.value = values.style;
        }
        if (values.color != null) {
            _color = new CssBorderTopColor();
            _color.setByUser();
            _color.value = values.color;
        }
    }

    /**
     * Returns a string representation of the object.
     */
    public String toString() {
        if (_width != null) {
            if (inherit == _width.value) {
                return inherit.toString();
            }
            if (initial == _width.value) {
                return initial.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        if (_width != null) {
            sb.append(_width);
            first = false;
        }
        if (_style != null) {
            if (first) {
                sb.append(_style);
            } else {
                sb.append(' ').append(_style);
            }
            first = false;
        }
        if (_color != null) {
            if (first) {
                sb.append(_color);
            } else {
                sb.append(' ').append(_color);
            }
        }
        return sb.toString();
    }

}
