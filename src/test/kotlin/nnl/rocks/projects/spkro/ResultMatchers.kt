package nnl.rocks.projects.spkro

import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultMatcher

class ResultMatchers(
    private val matchers: Iterable<ResultMatcher>
) : ResultMatcher {

    override fun match(result: MvcResult?) {
        matchers.forEach { it -> it.match(result) }
    }
}

fun ResultActions.andExpect(vararg matchers: ResultMatcher): ResultActions {
    return this.andExpect(ResultMatchers(matchers.toList()))
}
