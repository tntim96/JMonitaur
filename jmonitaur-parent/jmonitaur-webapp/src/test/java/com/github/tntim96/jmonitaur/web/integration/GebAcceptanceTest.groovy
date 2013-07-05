package com.github.tntim96.jmonitaur.web.integration

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class GebAcceptanceTest extends GebReportingSpec {

    def "Status HTML5"() {
        given : "I am at the status page"
        to GebStatusHtml5Page

        verifyContent()
    }

    def "Status AngularJS"() {
        given : "I am at the status page"
        to GebStatusAngularJSPage

        verifyContent()
    }

    private void verifyContent() {
        def row1 = $("table.healthTable").find("tr", 1)
        assert row1.find("td", 0).text() == "CRITICAL"
        assert row1.find("td", 1).text() == "Shields"
        assert row1.find("td", 2).text() == "30% power"
    }

}