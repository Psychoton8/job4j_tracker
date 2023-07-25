package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает действия над банковским счетом:
 * Регистрация и удаление пользователя, добаление пользователю счетов,
 * перевод средств со счета на счет.
 * @author Milana
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему, если его еще нет в базе
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает номер паспорта, по которому выполняется поиск пользователя.
     * Если пользователь найден - удаляется.
     *
     * @param passport номер паспорта
     * @return true если найден(удаление), false если нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает номер паспорта, по которому нужно добавить счет.
     * @param passport номер паспорта
     * @param account номер счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> newAccount = users.get(user);
            if (!newAccount.contains(account)) {
                newAccount.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по номеру паспорта.
     * @param passport номер паспорта
     * @return user если пользователь найден, null если не найден.
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод осуществляет поиск пользователя по номеру паспорта и реквизитам.
     * @param passport номер паспорта
     * @param requisite реквизиты
     * @return account если счет найден, null если не найдено.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод осуществляет перевод средств с одного счета на другой.
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return true - если все упомянутые выше данные найдены, false - если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account scr = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (scr != null && dest != null && scr.getBalance() >= amount) {
            scr.setBalance(scr.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает пользователя, чей счет необходимо найти.
     * @param user пользователь
     * @return List всех счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
