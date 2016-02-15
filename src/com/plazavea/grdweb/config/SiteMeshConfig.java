package com.plazavea.grdweb.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshConfig extends ConfigurableSiteMeshFilter{

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder
		// Exclude path from decoration.
//		.addExcludedPath("/css/*")
//		.addExcludedPath("/img/*")
//		.addExcludedPath("/js/*")
//		.addExcludedPath("/*/excel/*")
		.addExcludedPath("/*/ajax/*")
		.addExcludedPath("/seguridad/*")
		// Include path from decoration.
//		.addDecoratorPath("/seguridad/*", "/WEB-INF/jsp/layouts/default.jsp")
//		.addDecoratorPath("/portal/*", "/WEB-INF/jsp/layouts/default.jsp")
		.addDecoratorPath("*", "/WEB-INF/jsp/layouts/default.jsp")
		;
	}
}