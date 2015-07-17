package com.revlon.error;


import com.google.common.collect.Lists;
import com.wordnik.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@ApiModel(value = "List of Problems with Request")
public class Problems {

    List<Problem> problems;

    public Problems() {
        this.problems = new ArrayList<Problem>();
    }

    public Problems(Problem problem) {
        this(Arrays.asList(problem));
    }

    public Problems(Iterable<Problem> problems) {
        this.problems = Lists.newArrayList(problems);
    }

    @XmlElementRef()
    public List<Problem> getProblems() {
        return problems;
    }

    public void add(Problem problem){
        this.problems.add(problem);
    }
}
