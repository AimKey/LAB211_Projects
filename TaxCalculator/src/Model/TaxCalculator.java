package Model;

import java.util.Arrays;

public class TaxCalculator {

    public TaxCalculator() {
    }
    // TODO: Delete all the println

    /*
     * Maximum deduction up to 2 children:
     * < 18: 4.400.000 VND
     * Studying type:
     * >= 18: 6.000.000 VND
     * Not study and >= 18 || > 22 -> no deduction
     * If more than 2 children, only takes 2 chid with the highest deduction ammount
     * 
     * If only child:
     * Deduction for parents >= 60: 4.400.000 per/person (< 60 is no deduction)
     * If have sibs:
     * Deduction get is : 4.400.000 / n (where n is the number of siblings)
     */
    public int calcDeduction(Person p) {
        int childDeduction = calcChildDeduction(p.getChildren());
        int parrentDeduction = calcParentDeduction(p.getParents(), p.getNumOfSiblings());
        int remainMoney = p.getIncome() - childDeduction - parrentDeduction - 11000000;
        int taxMoney = 0;
        int remainder = 0;
        System.out.println("Money for tax: " + remainMoney);
        if (remainMoney < 4000000) {
            taxMoney = remainMoney * (2 / 100);
            return taxMoney;
        } else {
            if (remainMoney > 10000000) {
                remainder = remainMoney - 10000000; // Ex: 30tr - 10tr con lai 20tr
                taxMoney += remainder * 20 / 100; // 20 tr dem di tinh thue
                remainMoney = remainMoney - remainder; // 10 tr dem di tinh tiep
                System.out.println("After 10tr: " + taxMoney);
                
            }
            if (remainMoney > 6000000) {
                remainder = remainMoney - 6000000; // Ex: 10tr - 6tr con lai 4 tr
                taxMoney += remainder * 10 / 100; // 4 tr dem di tinh thue (hoac phan con lai)
                remainMoney = remainMoney - remainder; // Phan con lai la 10tr - 4tr con 6 tr
                System.out.println("After 6tr: " + taxMoney);

            }
            if (remainMoney > 4000000) {
                remainder = remainMoney - 4000000; // Ex: 6 tr - 4 tr con 2 tr or phan con lai
                taxMoney += remainder * 5 / 100; // 2 tr dem di tinh thue (hoac phan con lai)
                remainMoney = remainMoney - remainder; // Phan con lai la 6tr - 2tr con 4tr
                System.out.println("After 4tr: " + taxMoney);
            }
            taxMoney += remainMoney * 2 / 100;
            System.out.println("Final: " + taxMoney);
        }
        return taxMoney;
    }

    private int calcParentDeduction(Person[] ps, int sibNum) {
        int total = 0;
        for (Person parrent : ps) {
            if (parrent.getAge() >= 60) {
                total += 4400000;
            }
        }
        if (sibNum == 0) {
            return total;
        } else {
            return total / (sibNum + 1);
        }
    }

    private int calcChildDeduction(Child[] childs) {
        int childrenDeductionCost = 0;
        int[] childDeductions = new int[childs.length];
        for (int i = 0; i < childs.length; i++) {
            Child child = childs[i];
            int age = child.getAge();
            boolean study = child.getIsStudy();
            if (!study && age >= 18 || age > 22) {
                childDeductions[i] = 0;
            } else if (age < 18) {
                childDeductions[i] = 4400000;
            } else {
                childDeductions[i] = 6000000;
            }
        }
        System.out.println(Arrays.toString(childDeductions));
        Arrays.sort(childDeductions);
        System.out.println(Arrays.toString(childDeductions));
        int count = 0;
        for (int i = childDeductions.length - 1; i >= 0; i--) {
            if (count >= 2) {
                break;
            }
            childrenDeductionCost += childDeductions[i];
            count++;
        }
        return childrenDeductionCost;
    }
}
