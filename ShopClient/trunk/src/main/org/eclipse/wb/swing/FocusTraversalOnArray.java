/*******************************************************************************
 * Copyright (C) 2017 Pavel Mayzenberg and Amos Refael
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 * Cyclic focus traversal policy based on array of components.
 * <p>
 * This class may be freely distributed as part of any application or plugin.
 * 
 * @author scheglov_ke
 */
public class FocusTraversalOnArray extends FocusTraversalPolicy {
	private final Component m_Components[];
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	public FocusTraversalOnArray(Component components[]) {
		m_Components = components;
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Utilities
	//
	////////////////////////////////////////////////////////////////////////////
	private int indexCycle(int index, int delta) {
		int size = m_Components.length;
		int next = (index + delta + size) % size;
		return next;
	}
	private Component cycle(Component currentComponent, int delta) {
		int index = -1;
		loop : for (int i = 0; i < m_Components.length; i++) {
			Component component = m_Components[i];
			for (Component c = currentComponent; c != null; c = c.getParent()) {
				if (component == c) {
					index = i;
					break loop;
				}
			}
		}
		// try to find enabled component in "delta" direction
		int initialIndex = index;
		while (true) {
			int newIndex = indexCycle(index, delta);
			if (newIndex == initialIndex) {
				break;
			}
			index = newIndex;
			//
			Component component = m_Components[newIndex];
			if (component.isEnabled() && component.isVisible() && component.isFocusable()) {
				return component;
			}
		}
		// not found
		return currentComponent;
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// FocusTraversalPolicy
	//
	////////////////////////////////////////////////////////////////////////////
	public Component getComponentAfter(Container container, Component component) {
		return cycle(component, 1);
	}
	public Component getComponentBefore(Container container, Component component) {
		return cycle(component, -1);
	}
	public Component getFirstComponent(Container container) {
		return m_Components[0];
	}
	public Component getLastComponent(Container container) {
		return m_Components[m_Components.length - 1];
	}
	public Component getDefaultComponent(Container container) {
		return getFirstComponent(container);
	}
}
