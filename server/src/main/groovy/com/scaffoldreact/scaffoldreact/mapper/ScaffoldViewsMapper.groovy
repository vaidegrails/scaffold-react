package com.scaffoldreact.scaffoldreact.mapper

import com.scaffoldreact.scaffoldreact.annotation.ScaffoldViews
import com.scaffoldreact.scaffoldreact.menu.MappedMenu
import com.scaffoldreact.scaffoldreact.menu.MappedMenuItem
import com.scaffoldreact.scaffoldreact.view.ScaffoldViewsMapping
import com.scaffoldreact.scaffoldreact.views.AbstractMappedView
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter

@Slf4j
class ScaffoldViewsMapper {
    List<ScaffoldViewsMapping> mappings = new ArrayList<>()
    List<MappedMenu> menuList = new ArrayList<>()

    /**
     * It maps all the scaffold views, including the menus and submenus
     */
    void map() {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false)

        scanner.addIncludeFilter(new AnnotationTypeFilter(ScaffoldViews.class))

        List mappedMenuItems = []
        log.info("Initializing ScaffoldViewsMapper")
        for (BeanDefinition aClass : scanner.findCandidateComponents("")) {
            log.info("Mapping class ${aClass.getBeanClassName()}")
            ScaffoldViewsMapping scaffoldViewsMapping = mapViews(aClass)
            mapMenus(scaffoldViewsMapping, mappedMenuItems)
        }
        mapSubMenus(mappedMenuItems)
    }

    /**
     * Map all the views associated with a bean with the annotation ScaffoldViews
     * @param bd Bean annotated with Scaffoldviews annotation
     * @return The mapping of the bean
     */
    private ScaffoldViewsMapping mapViews(BeanDefinition bd) {
        def scaffoldViewsMapping = new ScaffoldViewsMapping(Class.forName(bd.getBeanClassName()))
        mappings.add(scaffoldViewsMapping)
        return scaffoldViewsMapping
    }

    /**
     * Map all the submenu items found in the mappings
     * @param mappedMenuItems The list of mapped menus to add
     */
    private void mapSubMenus(List mappedMenuItems) {
        mappedMenuItems.each { MappedMenuItem mappedMenuItem ->
            MappedMenu mappedMenu = menuList.find { it.root == mappedMenuItem.root }
            if (!mappedMenu) {
                mappedMenu = new MappedMenu(root: mappedMenuItem.root, title: mappedMenuItem.root)
                menuList.add(mappedMenu)
            }
            mappedMenu.items.add(mappedMenuItem)
        }
    }

    /**
          * Map all the menu items found in the mappings
          * @param scaffoldViewsMapping The mapping
          * @param mappedMenuItems The list of mapped submenus to add
          */
    private void mapMenus(ScaffoldViewsMapping scaffoldViewsMapping, List mappedMenuItems) {
        if (!(menuList.find { it.root == scaffoldViewsMapping.menu.root }) && scaffoldViewsMapping.menu!=null) {
            menuList.add(scaffoldViewsMapping.menu)
        }
        mappedMenuItems.addAll(scaffoldViewsMapping.subMenuItems)
    }

    private ScaffoldViewsMapping findMappingsByClass(Class aClass) {
        return this.mappings.find { mapping ->
            mapping.annotatedClass == aClass
        }
    }

    AbstractMappedView findMappedViewByClassAndType(Class aClass, String type) {
        AbstractMappedView abstractMappedView = null
        ScaffoldViewsMapping scaffoldViewsMapping = this.findMappingsByClass(aClass)

        if (scaffoldViewsMapping) {
            abstractMappedView = scaffoldViewsMapping.findByType(type)
        }

        return abstractMappedView
    }


}
