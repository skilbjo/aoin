begin;

  insert into dw.currency_fact values
    ('CURRFX', 'GBPUSD', 'GBP', '2017-12-15', 1.34329152107240, 1.34498989582060, 1.33081364631650),
    ('CURRFX', 'GBPUSD', 'GBP', '2017-12-14', 1.34096789360050, 1.34556913375850, 1.33951294422150),
    ('CURRFX', 'EURUSD', 'EUR', '2017-12-15', 1.17749571800230, 1.18140053749080, 1.17616617679600),
    ('CURRFX', 'EURUSD', 'EUR', '2017-12-14', 1.18358600139620, 1.18598639965060, 1.17716300487520)
  ;

  insert into dw.equities_fact values
    ('WIKI', 'FB'  , '2017-09-05', 170.91, 172.09, 169.57, 172.48, 13659317.00, 1.00, 170.91, 172.09, 169.57, 172.48, 13659317.00, 0.00 ),
    ('WIKI', 'AMZN', '2017-09-07', 979.10, 965.90, 963.47, 979.88,  2578269.00, 1.00, 979.10, 965.90, 963.47, 979.88,  2578269.00, 0.00 ),
    ('WIKI', 'GOOG', '2017-09-14', 924.66, 920.29, 916.36, 926.49,  2475031.00, 1.00, 924.66, 920.29, 916.36, 926.49,  2475031.00, 0.00 ),
    ('WIKI', 'NVDA', '2017-09-06', 166.49, 166.58, 164.95, 167.89,  8731886.00, 1.00, 166.49, 166.58, 164.95, 167.89,  8731886.00, 0.00 ),
    ('WIKI', 'NVDA', '2017-09-04', 168.38, 165.91, 163.56, 168.58, 17358768.00, 1.00, 168.38, 165.91, 163.56, 168.58, 17358768.00, 0.00 )
  ;

  insert into dw.portfolio_dim values
    ('skilbjo', 'ALPHA-VANTAGE',    'V', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',   'CY', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',   'FB', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',   'GS', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',   'SQ', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',   'MA', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'AXP', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'AMD', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'CRM', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'GLD', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'IAU', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'IBM', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'ICE', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'SAP', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'TSM', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'TXN', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'UBER', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'AAPL', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'AMZN', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'APPF', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'GOOG', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'INTC', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'INTU', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'MSFT', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'NDAQ', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'NVDA', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'PYPL', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'SHOP', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'TWLO', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE', 'TWTR', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','BRK-B', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','BRK.B', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','NTDOF', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','NTDOY', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','SFTBF', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'VEA', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VEMAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VEURX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VEXPX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'VFH', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VGSLX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'VGT', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VGWAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE',  'VHT', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VIMAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VINEX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VTIAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VTSAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VWINX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VWENX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VITAX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VMMSX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VMMXX', 3, 100.00 ),
    ('skilbjo', 'ALPHA-VANTAGE','VMRAX', 3, 100.00 )

;

insert into dw.equities_fact (dataset, ticker, date, close) values
    ('ALPHA-VANTAGE',    'MA',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'AXP',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'APPF',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'SHOP',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'NDAQ',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'MSFT',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'ICE',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'IBM',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'AMD',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'CRM',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'PCG',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',   'TXN',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'TWTR',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'PYPL',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'NVDA',  '2019-01-01', 100.00 ),
    ('ALPHA-VANTAGE',  'AAPL',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'AMZN',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'BRK-B',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'BRK.B',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',    'CY',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',    'FB',  '2017-09-05', 500.00 ),
    ('ALPHA-VANTAGE',    'FB',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'GLD',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'GOOG',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',    'GS',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'IAU',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'INTC',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'INTU',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'NTDOF',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'NTDOY',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'NVDA',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'PYPL',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'SAP',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'SFTBF',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',    'SQ',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'TSM',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',  'TWTR',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'TXN',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',     'V',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'VEA',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VEMAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VEURX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VEXPX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'VFH',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VGSLX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VTIAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VTSAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VWINX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VWENX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'VGT',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VGWAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE',   'VHT',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VIMAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VINEX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VITAX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VMMSX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VMMXX',  '2019-02-22', 500.00 ),
    ('ALPHA-VANTAGE', 'VMRAX',  '2019-02-22', 500.00 )
  ;

commit;
