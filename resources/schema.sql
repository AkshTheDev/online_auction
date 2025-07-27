# AccountTransactions
CREATE TABLE `account_transactions` (
                                        `account_transaction_id` int NOT NULL AUTO_INCREMENT,
                                        `wallet_id` int DEFAULT NULL,
                                        `bank_account_id` int DEFAULT NULL,
                                        `amount` decimal(12,2) DEFAULT NULL,
                                        `transaction_type` enum('withdrawal','deposit') NOT NULL,
                                        `transaction_status` enum('pending','completed','failed') DEFAULT 'completed',
                                        `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`account_transaction_id`),
                                        KEY `wallet_id` (`wallet_id`),
                                        KEY `bank_account_id` (`bank_account_id`),
                                        KEY `idx_account_transactions_by_type` (`transaction_type`),
                                        CONSTRAINT `account_transactions_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `wallets` (`wallet_id`),
                                        CONSTRAINT `account_transactions_ibfk_2` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_accounts` (`bank_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# Auctions
CREATE TABLE `auctions` (
                            `auction_id` int NOT NULL AUTO_INCREMENT,
                            `auction_name` varchar(255) DEFAULT NULL,
                            `start_time` datetime DEFAULT NULL,
                            `end_time` datetime DEFAULT NULL,
                            `status` enum('scheduled','ongoing','completed') DEFAULT 'scheduled',
                            `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`auction_id`),
                            KEY `idx_active_auctions` (`end_time`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# audit logs
CREATE TABLE `audit_logs` (
                              `log_id` int NOT NULL AUTO_INCREMENT,
                              `user_id` int DEFAULT NULL,
                              `item_id` int DEFAULT NULL,
                              `auction_id` int DEFAULT NULL,
                              `action_type` enum('created','updated','deleted','bid_placed','login','logout','kyc_verified') NOT NULL,
                              `action_title` varchar(255) DEFAULT NULL,
                              `details` json DEFAULT NULL,
                              `ip_address` varchar(45) DEFAULT NULL,
                              `user_agent` text,
                              `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (`log_id`),
                              KEY `user_id` (`user_id`),
                              KEY `item_id` (`item_id`),
                              KEY `auction_id` (`auction_id`),
                              CONSTRAINT `audit_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
                              CONSTRAINT `audit_logs_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
                              CONSTRAINT `audit_logs_ibfk_3` FOREIGN KEY (`auction_id`) REFERENCES `auctions` (`auction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# bank_accounts
CREATE TABLE `bank_accounts` (
                                 `bank_account_id` int NOT NULL AUTO_INCREMENT,
                                 `user_id` int DEFAULT NULL,
                                 `account_number` varchar(30) NOT NULL,
                                 `ifsc_code` varchar(15) DEFAULT NULL,
                                 `bank_name` varchar(100) DEFAULT NULL,
                                 `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`bank_account_id`),
                                 KEY `user_id` (`user_id`),
                                 CONSTRAINT `bank_accounts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# bids
CREATE TABLE `bids` (
                        `bid_id` int NOT NULL AUTO_INCREMENT,
                        `item_id` int DEFAULT NULL,
                        `bidder_id` int DEFAULT NULL,
                        `amount` decimal(12,2) DEFAULT NULL,
                        `timestamp` datetime DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`bid_id`),
                        KEY `idx_highest_bid_per_item` (`item_id`,`timestamp` DESC),
                        KEY `idx_user_bids` (`bidder_id`,`timestamp`),
                        CONSTRAINT `bids_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
                        CONSTRAINT `bids_ibfk_2` FOREIGN KEY (`bidder_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# Items
CREATE TABLE `items` (
                         `item_id` int NOT NULL AUTO_INCREMENT,
                         `item_name` varchar(255) DEFAULT NULL,
                         `description` text,
                         `start_price` decimal(12,2) DEFAULT NULL,
                         `reserve_price` decimal(12,2) DEFAULT NULL,
                         `seller_id` int DEFAULT NULL,
                         `auction_id` int DEFAULT NULL,
                         `status` enum('unsold','sold') DEFAULT 'unsold',
                         `listing_fee` decimal(12,2) DEFAULT NULL,
                         `res_hide_fee` decimal(12,2) DEFAULT NULL,
                         `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`item_id`),
                         KEY `idx_items_by_auction` (`auction_id`),
                         KEY `idx_items_by_seller` (`seller_id`),
                         CONSTRAINT `items_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `users` (`user_id`),
                         CONSTRAINT `items_ibfk_2` FOREIGN KEY (`auction_id`) REFERENCES `auctions` (`auction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# users
CREATE TABLE `users` (
                         `user_id` int NOT NULL AUTO_INCREMENT,
                         `email` varchar(255) NOT NULL,
                         `phone` varchar(15) NOT NULL,
                         `first_name` varchar(100) DEFAULT NULL,
                         `last_name` varchar(100) DEFAULT NULL,
                         `kyc_status` enum('pending','verified','rejected') DEFAULT 'pending',
                         `kyc_verified_at` datetime DEFAULT NULL,
                         `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `email` (`email`),
                         UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# wallet_transactions_breakdown
CREATE TABLE `wallet_transaction_breakdowns` (
                                                 `breakdown_id` int NOT NULL AUTO_INCREMENT,
                                                 `wallet_transaction_id` int DEFAULT NULL,
                                                 `amount` decimal(12,2) DEFAULT NULL,
                                                 `description` text,
                                                 `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                                 PRIMARY KEY (`breakdown_id`),
                                                 KEY `wallet_transaction_id` (`wallet_transaction_id`),
                                                 CONSTRAINT `wallet_transaction_breakdowns_ibfk_1` FOREIGN KEY (`wallet_transaction_id`) REFERENCES `wallet_transactions` (`wallet_transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# wallet_transactions
CREATE TABLE `wallet_transactions` (
                                       `wallet_transaction_id` int NOT NULL AUTO_INCREMENT,
                                       `from_wallet_id` int DEFAULT NULL,
                                       `to_wallet_id` int DEFAULT NULL,
                                       `amount` decimal(12,2) DEFAULT NULL,
                                       `transaction_type` enum('charges','transfer','refund') NOT NULL,
                                       `transaction_status` enum('pending','completed','failed') DEFAULT 'completed',
                                       `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                       PRIMARY KEY (`wallet_transaction_id`),
                                       KEY `from_wallet_id` (`from_wallet_id`),
                                       KEY `to_wallet_id` (`to_wallet_id`),
                                       KEY `idx_wallet_transactions_by_type` (`transaction_type`),
                                       CONSTRAINT `wallet_transactions_ibfk_1` FOREIGN KEY (`from_wallet_id`) REFERENCES `wallets` (`wallet_id`),
                                       CONSTRAINT `wallet_transactions_ibfk_2` FOREIGN KEY (`to_wallet_id`) REFERENCES `wallets` (`wallet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# wallets
CREATE TABLE `wallets` (
                           `wallet_id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int DEFAULT NULL,
                           `balance` decimal(12,2) DEFAULT '0.00',
                           `status` enum('active','blocked','suspended') DEFAULT 'active',
                           `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (`wallet_id`),
                           UNIQUE KEY `user_id` (`user_id`),
                           CONSTRAINT `wallets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# Winning_bids
CREATE TABLE `winning_bids` (
                                `win_id` int NOT NULL AUTO_INCREMENT,
                                `item_id` int DEFAULT NULL,
                                `bid_id` int DEFAULT NULL,
                                `conversion_fee` decimal(12,2) DEFAULT NULL,
                                `transaction_fee` decimal(12,2) DEFAULT NULL,
                                `payment_status` enum('pending','paid','failed') DEFAULT 'pending',
                                `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`win_id`),
                                UNIQUE KEY `item_id` (`item_id`),
                                KEY `bid_id` (`bid_id`),
                                KEY `idx_winner_auction` (`item_id`),
                                CONSTRAINT `winning_bids_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
                                CONSTRAINT `winning_bids_ibfk_2` FOREIGN KEY (`bid_id`) REFERENCES `bids` (`bid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
