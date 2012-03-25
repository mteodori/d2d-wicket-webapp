package com.mycompany;

import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;

public class PathStripperLocator extends ResourceStreamLocator {

    public IResourceStream locate(final Class<?> clazz, final String path) {
        // trying to find the resource without specifying a package
        IResourceStream located = super.locate(clazz, trimFolders(path));
        if (located != null) {
            return located;
        }
        // if not found use default strategy to locate
        return super.locate(clazz, path);
    }

    private String trimFolders(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

}
