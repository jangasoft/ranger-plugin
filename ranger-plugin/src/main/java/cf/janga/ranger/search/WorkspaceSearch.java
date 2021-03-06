package cf.janga.ranger.search;

import org.eclipse.jdt.core.IJavaProject;

import cf.janga.ranger.core.Source;
import cf.janga.ranger.core.TrackingConstraint;
import cf.janga.ranger.core.TrackingException;


/**
 * A type of search where the scope is the entire workspace.
 * 
 * @author Emerson Loureiro
 * 
 */
public class WorkspaceSearch extends AbstractSearch {

	/** List of projects in the workspace, where the search will take place. */
	private IJavaProject[] projects;

	/**
	 * Default constructor.
	 * 
	 * @param source
	 *            See {@link Search#getSource()}
	 * @param constraint
	 *            See {@link Search#getConstraint()}
	 * @param projects
	 *            The projects in the current workspace.
	 */
	public WorkspaceSearch(Source source, TrackingConstraint constraint, IJavaProject[] projects) {
		super(source, constraint);
		this.projects = projects;
	}

	/**
	 * Returns the projects in the workspace, where the search will take place.
	 * 
	 * @return
	 */
	public IJavaProject[] getProjects() {
		return this.projects;
	}

	/** {@inheritDoc} */
	@Override
	public void accept(SearchVisitor visitor) throws TrackingException {
		visitor.visit(this);
	}
}
