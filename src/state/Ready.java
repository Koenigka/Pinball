package state;


import automat.Machine;

public class Ready extends State {


        @Override
        public void addCoin(Machine machine) {
            super.addCoin(machine);
        }

        @Override
        public void start(Machine machine) {
            machine.setState(new Playing());
            if (machine.getCredit() > 0) {
                machine.setCredit(machine.getCredit() - 1);
                machine.setBalls(3);
                System.out.println("Game is starting! Have fun!");
            } else {
                machine.setState(new NoCredit());
                System.out.println("Please insert coin to play.");
            }
        }
}




