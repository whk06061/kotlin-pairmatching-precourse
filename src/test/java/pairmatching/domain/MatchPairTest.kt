package pairmatching.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MatchPairTest {
    val matchPair = MatchPair()
    @Test
    fun matchFE() {
        val crews = ReadFile().readFECrew()
        val pairs = mutableListOf<Set<String>>()
        pairs.add(setOf("리사", "보노"))
        pairs.add(setOf("윌터", "이브"))
        pairs.add(setOf("덴버", "쉐리"))
        pairs.add(setOf("로드", "린다"))
        pairs.add(setOf("다비", "제키"))
        pairs.add(setOf("시저", "니콜"))
        pairs.add(setOf("신디", "라라", "제시"))
        val result = matchPair.match(crews, pairs)
        println(result)
    }
    @Test
    fun matchBE(){
        val crews = ReadFile().readBECrew()
        val pairs = mutableListOf<Set<String>>()
        pairs.add(setOf("백호", "태웅"))
        pairs.add(setOf("치수", "태섭"))
        pairs.add(setOf("대만", "준호"))
        pairs.add(setOf("대협", "덕규"))
        pairs.add(setOf("태산", "경태"))
        pairs.add(setOf("수겸", "현준"))
        pairs.add(setOf("준섭", "한나"))
        pairs.add(setOf("소연", "호열"))
        pairs.add(setOf("대남", "용팔"))
        pairs.add(setOf("구식", "달재"))
        val result = matchPair.match(crews, pairs)
        println(result)
    }
}