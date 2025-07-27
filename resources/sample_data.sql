-- USERS
INSERT INTO users (email, phone, first_name, last_name, kyc_status)
VALUES
    ('alice@example.com', '9990010001', 'Alice', 'Wong', 'verified'),
    ('bob@example.com', '9990010002', 'Bob', 'Singh', 'verified');

-- WALLETS
INSERT INTO wallets (user_id, balance)
VALUES
    (1, 5000.00),
    (2, 7000.00);

-- BANK ACCOUNTS
INSERT INTO bank_accounts (user_id, account_number, ifsc_code, bank_name)
VALUES
    (1, '111122223333', 'IFSC001', 'Bank A'),
    (2, '444455556666', 'IFSC002', 'Bank B');

-- AUCTIONS
INSERT INTO auctions (auction_name, start_time, end_time, status)
VALUES
    ('Electronics Sale', NOW(), DATE_ADD(NOW(), INTERVAL 1 DAY), 'ongoing'),
    ('Furniture Flash', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 'scheduled');

-- ITEMS
INSERT INTO items (item_name, description, start_price, reserve_price, seller_id, auction_id, listing_fee, res_hide_fee)
VALUES
    ('Smartphone', 'Latest Android phone', 300.00, 500.00, 1, 1, 10.00, 5.00),
    ('Wooden Chair', 'Handmade oak chair', 50.00, 100.00, 1, 2, 5.00, 2.00);

-- BIDS
INSERT INTO bids (item_id, bidder_id, amount)
VALUES
    (1, 2, 320.00),
    (1, 2, 550.00);

-- WINNING BID
INSERT INTO winning_bids (item_id, bid_id, conversion_fee, transaction_fee, payment_status)
VALUES
    (1, 2, 5.00, 10.00, 'paid');

-- WALLET TRANSACTIONS
INSERT INTO wallet_transactions (from_wallet_id, to_wallet_id, amount, transaction_type, transaction_status)
VALUES
    (2, 1, 550.00, 'transfer', 'completed');

-- WALLET TRANSACTION BREAKDOWN
INSERT INTO wallet_transaction_breakdowns (wallet_transaction_id, amount, description)
VALUES
    (1, 10.00, 'Platform Fee');

-- ACCOUNT TRANSACTIONS
INSERT INTO account_transactions (wallet_id, bank_account_id, amount, transaction_type)
VALUES
    (1, 1, 500.00, 'deposit'),
    (2, 2, 700.00, 'deposit');

-- AUDIT LOGS
INSERT INTO audit_logs (user_id, item_id, auction_id, action_type, action_title, details, ip_address)
VALUES
    (2, 1, 1, 'bid_placed', 'Placed bid of 550', '{"bid":550}', '192.168.1.1');
