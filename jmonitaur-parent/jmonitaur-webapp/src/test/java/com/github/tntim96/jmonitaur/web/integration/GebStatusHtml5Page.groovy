package com.github.tntim96.jmonitaur.web.integration

import geb.Page

class GebStatusHtml5Page extends Page {
    static url = "service/status"

    static at = { title == "JMonitaur - Status" }

}
