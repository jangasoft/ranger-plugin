package cf.janga.ranger.search;

import org.eclipse.jdt.core.IJavaProject;

import cf.janga.ranger.core.Source;
import cf.janga.ranger.core.TrackingConstraint;
import cf.janga.ranger.core.TrackingException;


/**
 * A type of search parameter which dictates that the search is to be performed
 * at a project-level.
 * 
 * @author Emerson Loureiro
 * 
 */
public class ProjectSearch extends AbstractSearch {

	/** The project where the search is to be performed. */
	private IJavaProject project;

	/**
	 * Default constructor.
	 * 
	 * @param source
	 *            See {@link Search#getSource()}
	 * @param constraint
	 *            See {@link Search#getConstraint()}
	 * @param project
	 *            The project where the search is to be performed.
	 */
	public ProjectSearch(Source source, TrackingConstraint constraint, IJavaProject project) {
		super(source, constraint);
		this.project = project;
	}

	/**
	 * Returns the project where the search is to be performed.
	 * 
	 * @return {@link IJavaProject}
	 */
	public IJavaProject getProject() {
		return project;
	}

	/** {@inheritDoc} */
	@Override
	public void accept(SearchVisitor visitor) throws TrackingException {
		visitor.visit(this);
	}
}
