import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*
import java.awt.geom.Line2D
import java.awt.geom.Point2D

class KochPanel extends JPanel {
    @Override
    void paint(Graphics g) {
        super.paint(g)
        def gp = (Graphics2D) g
        def h = this.height - 10
        def l = h / 2
        double y = 5 + l / 2
        float len = l * Math.sqrt(3)
        double x = (this.width - len) / 2
        def pt1 = new Point2D.Double(x, y)
        def pt2 = new Point2D.Double(x + len, y)
        def pt3 = new Point2D.Double(
                (float) (x + len * Math.cos(Math.PI / 3)),
                (float) (y + len * Math.sin(Math.PI / 3)))
        drawKoch(gp, 5, pt1, 0.0, len)
        drawKoch(gp, 5, pt2, Math.PI * 2 / 3, len)
        drawKoch(gp, 5, pt3, -Math.PI * 2 / 3, len)
    }

    def drawKoch(Graphics2D g, depth, pt1, angle, length) {
        if (depth == 0) {
            def pt2 = new Point2D.Double(
                    pt1.x + length * Math.cos(angle),
                    pt1.y + length * Math.sin(angle),
            )
            def line = new Line2D.Float(pt1, pt2)
            g.draw(line)
        } else {
            def pt2 = new Point2D.Double(
                    (pt1.x + length / 3 * Math.cos(angle)),
                    (pt1.y + length / 3 * Math.sin(angle)),
            )
            def theta1 = angle - Math.PI / 3
            def theta2 = angle + Math.PI / 3
            def pt3 = new Point2D.Double(
                    pt2.x + length / 3 * Math.cos(theta1),
                    pt2.y + length / 3 * Math.sin(theta1),
            )
            def pt4 = new Point2D.Double(
                    pt1.x + length * 2 / 3 * Math.cos(angle),
                    pt1.y + length * 2 / 3 * Math.sin(angle),
            )
            drawKoch(g, depth - 1, pt1, angle, length / 3.0)
            drawKoch(g, depth - 1, pt2, theta1, length / 3)
            drawKoch(g, depth - 1, pt3, theta2, length / 3)
            drawKoch(g, depth - 1, pt4, angle, length / 3)
        }
    }
}

new SwingBuilder().edt {
    frame(title: 'Frame', size: [500, 500], show: true, defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
        borderLayout()
        widget(new KochPanel())
    }
}

