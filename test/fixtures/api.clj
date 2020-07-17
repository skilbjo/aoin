(ns fixtures.api
  (:require [clj-time.coerce :as coerce]
            [clojure.data.json :as json]))

(def api-response-from-currency      ;; use dev-resources/api script for data
  "{\"body\": [
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.34329152107240,
   \"high\":     1.34498989582060,
   \"low\":      1.33081364631650},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.17749571800230,
   \"high\":     1.18140053749080,
   \"low\":      1.17616617679600}
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.34096789360050,
   \"high\":     1.34556913375850,
   \"low\":      1.33951294422150},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.18358600139620,
   \"high\":     1.18598639965060,
   \"low\":      1.17716300487520}
   ]}")

                                 ;; use dev-resources/fixtures/fixture-helper
(def api-response-from-portfolio ;; for help creating this
  "{\"body\": [{\"description\": \"Portfolio Total\",\"cost_basis\": 12600,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"TOTAL\",\"market_value\": 63000,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"100.00%\",\"total_gain_loss\": 50400},{\"description\": \"Vanguard Global Wellington Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VGWAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"BERKSHIRE HATHAWAY INC DE CL B NEW\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"BRK.B\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard European Stock Index Fund Investor Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VEURX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"INTEL CORP\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"INTC\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"VISA INC CLASS A\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"V\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Nintendo Co., Ltd\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"NTDOF\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"iShares Gold Trust\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"IAU\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Total International Stock Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VTIAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"VANGUARD FINANCIALS ETF\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VFH\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"SAP SE ADR\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"SAP\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Total Stock Market Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VTSAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Amazon\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"AMZN\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"NINTENDO LTD/ADR\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"NTDOY\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Wellington Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VWENX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"CYPRESS SEMICONDUCTOR CORP\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"CY\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Apple Inc.\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"AAPL\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Google\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"GOOG\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Twitter Inc.\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"TWTR\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Intuit Inc.\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"INTU\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Emerging Markets Select Stock Fund Investor Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VMMSX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Real Estate Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VGSLX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Prime Money Market Fund\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VMMXX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"BERKSHIRE HATHAWAY INC DE CL B NEW\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"BRK-B\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Morgan Growth Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VMRAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"TEXAS INSTRUMENTS INC\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"TXN\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"PayPal Holdings Inc\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"PYPL\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Wellesley\u00ae Income Fund Investor Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VWINX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"SPDR Gold Trust\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"GLD\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Goldman Sachs Group Inc\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"GS\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Explorer Fund Investor Class\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VEXPX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Square Inc A\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"SQ\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"VANGUARD FTSE DEVELOPED MKTS ETF\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VEA\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"VANGUARD HEALTH CARE ETF\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VHT\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Mid-Cap Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VIMAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard International Explorer Fund Investor Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VINEX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"TAIWAN SEMICONDUCTOR MANUFACTURING COMPANY LTD SPONS ADR\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"TSM\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"VANGUARD INFORMATION TECHNOLOGY ETF\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VGT\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Facebook\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"FB\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Nvidia\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"NVDA\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Emerging Markets Stock Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VEMAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"Vanguard Information Technology Index Fund Admiral Shares\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"VITAX\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200},{\"description\": \"SoftBank Group Corp\",\"cost_basis\": 300,\"ytd_gain_loss_%\": \"0.00%\",\"date\": null,\"today_gain_loss\": 0,\"ticker\": \"SFTBF\",\"market_value\": 1500,\"today_gain_loss_%\": \"0.00%\",\"ytd_gain_loss\": 0,\"total_gain_loss_%\": \"400.00%\",\"mix_%\": \"2.38%\",\"total_gain_loss\": 1200}]}")

(def currency-result
  (-> api-response-from-currency
      (json/read-str
       :key-fn keyword
       :value-fn (fn [k v]
                   (condp = k
                     :date (coerce/to-sql-date v)
                     :rate (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :high (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :low  (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     v)))))

(def portfolio-result
  (-> api-response-from-portfolio
      (json/read-str :key-fn keyword)))
