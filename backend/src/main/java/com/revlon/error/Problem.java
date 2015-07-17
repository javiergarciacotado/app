package com.revlon.error;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@ApiModel(value = "Problem with Request")
public class Problem implements Serializable {

    private static final long serialVersionUID = 5827902773988067424L;

    @ApiModelProperty(value = "Specific description of Problem", required= true)
    private String detail;

    @ApiModelProperty(value = "Type of Problem", required= true)
    private ProblemType problemType;

    @ApiModelProperty(value = "General description of Problem", required= true)
    private String title;

    public Problem() {
    }

    public Problem(ProblemType problemType, String title, String detail) {
        this.problemType = problemType;
        this.title = title;
        this.detail = detail;
    }

    @XmlElement
    public ProblemType getProblemType() {
        return problemType;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    @XmlElement
    public String getDetail() {
        return detail;
    }
}
