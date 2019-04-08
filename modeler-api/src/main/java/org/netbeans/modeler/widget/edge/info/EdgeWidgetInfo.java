/**
 * Copyright 2013-2019 Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.modeler.widget.edge.info;

import java.util.function.Function;
import static org.netbeans.modeler.core.NBModelerUtil.getAutoGeneratedStringId;
import org.netbeans.modeler.specification.model.document.core.IBaseElement;
import org.netbeans.modeler.widget.edge.IEdgeWidget;
import org.netbeans.modeler.widget.info.WidgetInfo;

public class EdgeWidgetInfo implements WidgetInfo {

    private String id;
    private String name;
    private String source;
    private String target;
    private Boolean exist = false;
    private IBaseElement baseElementSpec;
    private String type;
    private Function<EdgeWidgetInfo, IEdgeWidget> edgeWidgetFunction;

    public EdgeWidgetInfo() {
        this.id = getAutoGeneratedStringId();
        this.name = "";
    }

    public EdgeWidgetInfo(Function<EdgeWidgetInfo, IEdgeWidget> edgeWidgetFunction) {
        this();
        this.edgeWidgetFunction = edgeWidgetFunction;
    }

    public EdgeWidgetInfo(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public IEdgeWidget createEdgeWidget() {
        return edgeWidgetFunction.apply(this);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String title) {
        this.name = title;
    }

    /**
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the exist
     */
    @Override
    public Boolean isExist() {
        return exist;
    }

    /**
     * @param exist the exist to set
     */
    @Override
    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    /**
     * @return the baseElementSpec
     */
    @Override
    public IBaseElement getBaseElementSpec() {
        return baseElementSpec;
    }

    /**
     * @param baseElementSpec the baseElementSpec to set
     */
    @Override
    public void setBaseElementSpec(IBaseElement baseElementSpec) {
        this.baseElementSpec = baseElementSpec;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
