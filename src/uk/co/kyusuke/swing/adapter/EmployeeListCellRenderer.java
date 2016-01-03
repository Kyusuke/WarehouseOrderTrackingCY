package uk.co.kyusuke.swing.adapter;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import uk.co.kyusuke.data.EmployeeData;

public class EmployeeListCellRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096595589329052063L;

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus){
		if (value instanceof EmployeeData){
			value = ((EmployeeData)value).getName();
		}
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		return this;
	}
}
